package RecordClass;

public class Pessoa {
    
    private String nome;
    private Double altura;
    
    public Pessoa(String nome, Double altura) {
        this.nome = nome;
        this.altura = altura;
    }
    
    // Getter para o campo nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public static void main(String[] args) {
     
        Pessoa pessoa = new Pessoa("Alexandre", 1.8);
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Altura: " + pessoa.getAltura());

    }
}