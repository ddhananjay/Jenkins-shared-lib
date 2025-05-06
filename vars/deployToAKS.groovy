def call(String tenantId, String subscriptionId, String resourceGroup, String aksCluster, String dockerImage, String azureCredsId) {
   stage('Azure Login') {
        withCredentials([usernamePassword(credentialsId: azureCredsId, usernameVariable: 'AZ_CLIENT_ID', passwordVariable: 'AZ_CLIENT_SECRET')]) {
            sh """
                /opt/homebrew/bin/az login --service-principal -u $AZ_CLIENT_ID -p $AZ_CLIENT_SECRET --tenant ${tenantId}
                /opt/homebrew/bin/az account set --subscription ${subscriptionId}
            """
        }
    }

    stage('Get AKS Credentials') {
        sh """
            /opt/homebrew/bin/az aks get-credentials --resource-group ${resourceGroup} --name ${aksCluster} --overwrite-existing
        """
    }

    stage('Deploy to AKS') {
        def deploymentName = 'myapp-deployment'
        def containerName = 'myapp-container'

        sh """
            /opt/homebrew/bin/kubectl apply -f k8s/deployment.yaml -n kube-system
            /opt/homebrew/bin/kubectl rollout status deployment/myapp-deployment -n kube-system
        """
    }
}
