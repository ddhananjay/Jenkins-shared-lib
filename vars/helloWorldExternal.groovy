def call(Map config) {
 def loadConfig = [name: 'hello-world.sh']
 loadExternalFile(loadConfig)
 sh "./hello-world.sh ${config.name} ${config.day}"
}
