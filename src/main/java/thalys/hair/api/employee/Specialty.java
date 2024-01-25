package thalys.hair.api.employee;

public enum Specialty {
    CORTE("Corte de Cabelo Feminino"),
    COLORACAO("Coloração e Mechas"),
    TRATAMENTO("Tratamentos Capilares"),
    PENTEADO("Penteados Especiais"),
    EXTENSAO("Trabalho com Extensões");

    private final String descricao;

    Specialty(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
