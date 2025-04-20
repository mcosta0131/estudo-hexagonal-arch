package contracts.duplicata

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "Deve criar uma duplicata com sucesso"

    request {
        method 'POST'
        url '/duplicatas'
        body(
                nomeSacador: "João da Silva",
                valorDuplicata: 1500.00
        )
        headers {
            contentType(applicationJson())
        }
    }

    response {
        status OK()
        body(
                nomeSacador: "João da Silva",
                valorDuplicata: 1500.00
        )
        headers {
            contentType(applicationJson())
        }
    }
}
