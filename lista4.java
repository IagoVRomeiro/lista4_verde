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
    private int qtdComparacoes;

    void setISBN(long x) {
        this.ISBN = x;
    }

    void setTitulo(String x) {
        this.titulo = x;
    }

    void setAutor_principal(String x) {
        this.autor_principal = x; // Corrected here
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
        if(this.getSegundo_autor().equals("")){
        return this.getAutor_principal() +". " + this.getTitulo() + ". " + this.getAno_publicacao() + ". ISBN: " + this.getISBN() + ". " + "Sequencial:" this.qtdComparacao;
        }
        else{
        return this.getAutor_principal() + ", " + this.getSegundo_autor() +". " + this.getTitulo() + ". " + this.getAno_publicacao() + ". ISBN: " + this.getISBN() + ". ";
        }
    }

    public void imprimir() {
       toString();
    }
    

     public Livro clone() {
        return new Livro(this.ISBN, this.titulo, this.autor_principal, this.segundo_autor, this.categoria, this.descricao, this.ano_publicacao,
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

}

public class lista3 {

    public static void main(String[] args) {

        // qtd do vetor
        int qtd = MyIO.readInt();
        // vetor livro
        Livro[] livros1 = new Livro[qtd];

        String linha = MyIO.readLine();
        int i = 0;
        while (!linha.equals("FIM")) {

            String[] info = linha.split("\\|");

            long isbn = Long.parseLong(info[0]);
            String titulo = info[1];
            String autor_principal = info[2];
            String segundo_autor = info[3];
            String categoria = info[4];
            String descricao = info[5];
            int ano_publicacao = Integer.parseInt(info[6]);
            int quantidade_paginas = Integer.parseInt(info[7]);
            float nota_avaliacao = Float.parseFloat(info[8]);
            int quantidade_avaliacoes = Integer.parseInt(info[9]);

            livros1[i] = new Livro(isbn, titulo, autor_principal, segundo_autor, categoria, descricao, ano_publicacao, quantidade_paginas, nota_avaliacao, quantidade_avaliacoes);
            i++;

            linha = MyIO.readLine();
        }

        linha = MyIO.readLine();

        Livro[] livros2 = new Livro[qtd];
        while (!linha.equals("FIM")) {
            String[] info = linha.split("\\|");

            long isbn = Long.parseLong(info[0]);
            String titulo = info[1];
            String autor_principal = info[2];
            String segundo_autor = info[3];
            String categoria = info[4];
            String descricao = info[5];
            int ano_publicacao = Integer.parseInt(info[6]);
            int quantidade_paginas = Integer.parseInt(info[7]);
            float nota_avaliacao = Float.parseFloat(info[8]);
            int quantidade_avaliacoes = Integer.parseInt(info[9]);

            livros2[i] = new Livro(isbn, titulo, autor_principal, segundo_autor, categoria, descricao, ano_publicacao, quantidade_paginas, nota_avaliacao, quantidade_avaliacoes);
            i++;

            linha = MyIO.readLine();
            }

            String titulo = MyIO.readLine();
            while (!linha.equals("FIM")) {
                pesquisaBinaria(livro2, titulo);
                pesquisaSequencial(livro1, titulo);
                titulo = MyIO.readLine();
            }

            void pesquisaBinaria(Livro[] livro, String titulo){
            int qtdComparacao=0;
            int dir = qtd - 1, esq = 0, meio;
            while (esq <= dir) {
            meio = (esq + dir) / 2;
            qtdComparacao++;
            if (titulo.equals(livro[meio])){
            qtdComparacao++;
            livro[meio].toString();
            } else if (titulo.compareTo(livro[meio]) > 0){
            esq = meio + 1;
            qtdComparacao++;
              } else {
            dir = meio - 1;
            qtdComparacao++;
              } 
            }
            }

            void pesquisaSequencial(Livro[] livro, String titulo){
                int qtdComparacoes=0;
            for (Livro livro : livros) {
                if (livro.getTitulo().equals(titulo)) {
                     MyIO.println(livro.toString()); 
                }
                else{
                    qtdComparacoes++;
                }
            }
        }
    }
}