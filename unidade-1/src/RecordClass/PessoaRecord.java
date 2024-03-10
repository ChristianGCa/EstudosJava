package RecordClass;

public record PessoaRecord(String nome, Double altura) { 

    public static void main(String[] args) {
     
        PessoaRecord pessoa = new PessoaRecord("Alex", 1.89);
        System.out.println("Nome: " + pessoa.nome());
        System.out.println("Altura: " + pessoa.altura());

    }
}
