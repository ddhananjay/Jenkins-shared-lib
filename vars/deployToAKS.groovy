def call(String deploymentFile, String clusterName, String region) {
    sh """
        # Update kubeconfig to access EKS
        aws eks update-kubeconfig --region ${region} --name ${clusterName}

        # Apply the Kubernetes deployment
        kubectl apply -f ${deploymentFile}
    """
}
