package com.mini.asaas.utils.enums

enum BrazilianStates {
    ACRE("Acre", "AC"),
    ALAGOAS("Alagoas", "AL"),
    AMAZONAS("Amazonas", "AM"),
    AMAPA("Amapá", "AP"),
    BAHIA("Bahia", "BA"),
    CEARA("Ceará", "CE"),
    DISTRITO_FEDERAL("Distrito Federal", "DF"),
    ESPIRITO_SANTO("Espírito Santo", "ES"),
    GOIAS("Goiás", "GO"),
    MARANHAO("Maranhão", "MA"),
    MATO_GROSSO("Mato Grosso", "MT"),
    MATO_GROSSO_DO_SUL("Mato Grosso do Sul", "MS"),
    MINAS_GERAIS("Minas Gerais", "MG"),
    PARA("Pará", "PA"),
    PARAIBA("Paraíba", "PB"),
    PARANA("Paraná", "PR"),
    PERNAMBUCO("Pernambuco", "PE"),
    PIAUI("Piauí", "PI"),
    RIO_DE_JANEIRO("Rio de Janeiro", "RJ"),
    RIO_GRANDE_DO_NORTE("Rio Grande do Norte", "RN"),
    RIO_GRANDE_DO_SUL("Rio Grande do Sul", "RS"),
    RONDONIA("Rondônia", "RO"),
    RORAIMA("Roraima", "RR"),
    SANTA_CATARINA("Santa Catarina", "SC"),
    SAO_PAULO("São Paulo", "SP"),
    SERGIPE("Sergipe", "SE"),
    TOCANTINS("Tocantins", "TO")

    final String fullName
    
    final String abbreviation

    BrazilianStates(String fullName, String abbreviation) {
        this.fullName = fullName
        this.abbreviation = abbreviation
    }

    static BrazilianStates fromName(String name) {
        for (brazilianState in values()) {
            if (brazilianState.fullName.equalsIgnoreCase(name) || brazilianState.abbreviation.equalsIgnoreCase(name)) {
                return brazilianState
            }
        }
        
        throw new IllegalArgumentException("Estado não encontrado: $name")
    }
}
