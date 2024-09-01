
class Livro {

    private long ISBN;
    private String titulo;
    private String autor_principal;
    private String segundo_autor;
    private String categoria;
    private String descricao;
    private int ano_publicacao;
    private int quantidade_paginas;
    private float nota_avaliacao;
    private int quantidade_avaliacoes;


    void setISBN(long x) {
        this.ISBN = x;
    }

    void setTitulo(String x) {
        this.titulo = x;
    }

    void setAutor_principal(String x) {
        this.autor_principal = x;
    }

    void setSegundo_autor(String x) {
        this.segundo_autor = x;
    }

    void setCategoria(String x) {
        this.categoria = x;
    }

    void setDescricao(String x) {
        this.descricao = x;
    }

    void setAno_publicacao(int x) {
        this.ano_publicacao = x;
    }

    void setQuantidade_paginas(int x) {
        this.quantidade_paginas = x;
    }

    void setNota_avaliacao(float x) {
        this.nota_avaliacao = x;
    }

    void setQuantidade_avaliacoes(int x) {
        this.quantidade_avaliacoes = x;
    }

    long getISBN() {
        return this.ISBN;
    }

    String getTitulo() {
        return this.titulo;
    }

    String getAutor_principal() {
        return this.autor_principal;
    }

    String getSegundo_autor() {
        return this.segundo_autor;
    }

    String getCategoria() {
        return this.categoria;
    }

    String getDescricao() {
        return this.descricao;
    }

    int getAno_publicacao() {
        return this.ano_publicacao;
    }

    int getQuantidade_paginas() {
        return this.quantidade_paginas;
    }

    float getNota_avaliacao() {
        return this.nota_avaliacao;
    }

    int getQuantidade_avaliacoes() {
        return this.quantidade_avaliacoes;
    }

    @Override
    public String toString() {
        if (this.getSegundo_autor().equals("")) {
            return this.getAutor_principal() + ". " + this.getTitulo() + ". " + this.getAno_publicacao() + ". ISBN: " + this.getISBN() + ". ";
        } else {
            return this.getAutor_principal() + ", " + this.getSegundo_autor() + ". " + this.getTitulo() + ". " + this.getAno_publicacao() + ". ISBN: " + this.getISBN() + ". ";
        }
    }

    public void imprimir() {
        System.out.print(toString());
    }

    public Livro clone() {
        return new Livro(this.ISBN, this.titulo, this.autor_principal, this.segundo_autor, this.categoria,
                this.descricao, this.ano_publicacao,
                this.quantidade_paginas, this.nota_avaliacao, this.quantidade_avaliacoes);
    }

    Livro() {
    }

    Livro(long isbn, String titulo, String autor_principal, String segundo_autor, String categoria,
            String descricao, int ano_publicacao, int quantidade_paginas, float nota_avaliacao,
            int quantidade_avaliacoes) {
        this.ISBN = isbn;
        this.titulo = titulo;
        this.autor_principal = autor_principal;
        this.segundo_autor = segundo_autor;
        this.categoria = categoria;
        this.descricao = descricao;
        this.ano_publicacao = ano_publicacao;
        this.quantidade_paginas = quantidade_paginas;
        this.nota_avaliacao = nota_avaliacao;
        this.quantidade_avaliacoes = quantidade_avaliacoes;
    }

    void ler(String linha) {

        String[] info = linha.split("\\|");

        this.setISBN(Long.parseLong(info[0]));
        this.setTitulo(info[1]);
        this.setAutor_principal(info[2]);
        this.setSegundo_autor(info[3]);
        this.setCategoria(info[4]);
        this.setDescricao(info[5]);
        this.setAno_publicacao(Integer.parseInt(info[6]));
        this.setQuantidade_paginas(Integer.parseInt(info[7]));
        this.setNota_avaliacao(Float.parseFloat(info[8]));
        this.setQuantidade_avaliacoes(Integer.parseInt(info[9]));

    }
                                                                                                                                                                                                                                                                                                                                              
     

}

public class Lista4 {
    
    static Livro ler2(String linha) {

        String[] info = linha.split("\\|");
        long ISBN = Long.parseLong(info[0]);
        String titulo = info[1];
        String autor_p = info[2];
        String autor_s = info[3];
        String categoria = info[4];
        String descricao = info[5];
        int ano = Integer.parseInt(info[6]);
        int qtd_paginas = Integer.parseInt(info[7]);
        float avaliacao = Float.parseFloat(info[8]);
        int qtd_avaliacao = Integer.parseInt(info[9]);

        return new Livro(ISBN, titulo, autor_p, autor_s, categoria, descricao, ano, qtd_paginas, avaliacao, qtd_avaliacao);

    }

    static int pesquisaBinaria(Livro[] livros, String titulo) {
        int qtdComparacoes = 0;
        int dir = livros.length - 1;
        int esq = 0;
        int meio;

        while (esq <= dir) {
            meio = (esq + dir) / 2;


            if (titulo.equals(livros[meio].getTitulo())) {
                qtdComparacoes++;
                return qtdComparacoes;
            } else if (titulo.compareTo(livros[meio].getTitulo()) > 0) {
                qtdComparacoes++;
                esq = meio + 1;
            } else {
                qtdComparacoes++;
                dir = meio - 1;

            }
        }

        return -1;
    }

    static int pesquisaSequencial(Livro[] livros, String titulo) {
        int qtdComparacoes = 0;

        for (Livro livro : livros) {

            if (livro.getTitulo().equals(titulo)) {
                qtdComparacoes++;

                return qtdComparacoes;
            } else {
                qtdComparacoes++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        // qtd do vetor
        int qtd = Integer.parseInt(MyIO.readLine());
        
        //vetor de livros 1 para pesquisa sequencial
        Livro[] livros1 = new Livro[qtd];
        //vetor de livros 2 para pesquisa binaria
        Livro[] livros2 = new Livro[qtd];

        String linha = MyIO.readLine();
        for (int i = 0; !linha.equals("FIM"); i++) {

            Livro livro = ler2(linha);
            livros1[i] = livro;

            linha = MyIO.readLine();
        }

        linha = MyIO.readLine();

        for (int i = 0; !linha.equals("FIM"); i++) {

            Livro livro = ler2(linha);
            livros2[i] = livro;

            linha = MyIO.readLine();
        }

        String titulo = MyIO.readLine();
        while (!titulo.equals("FIM")) {

   
                for (Livro livro : livros1) {
                    if (livro.getTitulo().equals(titulo)) {
                        livro.imprimir();
                        MyIO.println("Sequencial: " + pesquisaSequencial(livros1, titulo) + ", binaria: " + pesquisaBinaria(livros2, titulo));
                    }
                }
            
            
            titulo = MyIO.readLine();

        }
    }
}
