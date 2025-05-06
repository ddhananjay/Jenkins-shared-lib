def call(String tenantId, String subscriptionId, String resourceGroup, String aksCluster, String dockerImage, String azureCredsId, String dockerImage) {
   stage('Azure Login') {
        withCredentials([usernamePassword(credentialsId: azureCredsId, usernameVariable: 'AZ_CLIENT_ID', passwordVariable: 'AZ_CLIENT_SECRET')]) {
            sh """
                az login --service-principal -u $AZ_CLIENT_ID -p $AZ_CLIENT_SECRET --tenant ${tenantId}
                az account set --subscription ${subscriptionId}
            """
        }
    }

    stage('Get AKS Credentials') {
        sh """
            az aks get-credentials --resource-group ${resourceGroup} --name ${aksCluster} --overwrite-existing
        """
    }

    stage('Deploy to AKS') {
        def deploymentName = 'myapp-deployment'
        def containerName = 'myapp-container'

        sh """
            kubectl set image deployment/${deploymentName} ${containerName}=${dockerImage} --record
            kubectl rollout status deployment/${deploymentName}
        """
    }
}
