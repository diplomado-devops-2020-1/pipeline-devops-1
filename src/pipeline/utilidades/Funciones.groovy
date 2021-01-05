package pipeline.utilidades

    def sayHi() {
        echo "Hi from Funciones!"
    }

    def sayHello(str) {
        echo "Hello ${str}"
    }

    def validarEtapasValidas(String etapasEscogidas, ArrayList pipelineEtapas){
        def etapas = []

        if(etapasEscogidas?.trim().toUpperCase()){

            etapasEscogidas.split(';').each{
                if(it in pipelineEtapas){
                    etapas.add(it)
                }else {
                    error "${it} no existe como Stage. Stages disponibles para ejecutar: ${pipelineEtapas}"
                }
            }
            println "Validación de stages correcta. Se ejecutarán los siguientes stages en orden : ${etapas}"
        }else{
            etapas = pipelineEtapas
            println "Parámetro de stages vacio. Se ejecutarán todas los stages en el siguiente orden : ${etapas}"
        }

        return etapas


    }

return this;