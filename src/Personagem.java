public class Personagem {

    private String nome;


    public Personagem(String nome) {
        this.nome = nome;
    }

    public boolean mover(String comando, Labirinto labirinto) {
        switch (comando) {
            case "w", "W" -> {
                return andarParaCima(labirinto);
            }
            case "s", "S" -> {
                return andarParaBaixo(labirinto);
            }
            case "d", "D" -> {
                return andarParaFrente(labirinto);
            }
            case "a", "A" -> {
                return andarParaTras(labirinto);
            }
        }
        return false;
    }

    private boolean andarParaCima(Labirinto labirinto) {
        int l = labirinto.getLinhaPersonagem(this);
        int c = labirinto.getColunaPersonagem(this);

        if (labirinto.checarCaminhoLivre(l - 1, c)) {
            labirinto.getMapa()[l][c] = " ";
            labirinto.getMapa()[l - 1][c] = this.toString();
            return true;
        }

        return false;
    }

    private boolean andarParaBaixo(Labirinto labirinto) {
        int l = labirinto.getLinhaPersonagem(this);
        int c = labirinto.getColunaPersonagem(this);

        if (labirinto.checarCaminhoLivre(l + 1, c)) {
            labirinto.getMapa()[l][c] = " ";
            labirinto.getMapa()[l + 1][c] = this.toString();
            return true;
        }

        return false;
    }

    private boolean andarParaFrente(Labirinto labirinto) {
        int l = labirinto.getLinhaPersonagem(this);
        int c = labirinto.getColunaPersonagem(this);

        if (labirinto.checarCaminhoLivre(l, c + 1)) {
            labirinto.getMapa()[l][c] = " ";
            labirinto.getMapa()[l][c + 1] = this.toString();
            return true;
        }

        return false;
    }

    private boolean andarParaTras(Labirinto labirinto) {
        int l = labirinto.getLinhaPersonagem(this);
        int c = labirinto.getColunaPersonagem(this);

        if (labirinto.checarCaminhoLivre(l, c - 1)) {
            labirinto.getMapa()[l][c] = " ";
            labirinto.getMapa()[l][c - 1] = this.toString();
            return true;
        }

        return false;
    }


    public boolean escapouLabirinto(Labirinto labirinto) {
        return labirinto.personagemNaSaida();
    }

    public String getVisao(Labirinto labirinto) {
        String visao = "";
        String[][] mapa = labirinto.getMapa();
        Integer l = labirinto.getLinhaPersonagem(this);
        Integer c = labirinto.getColunaPersonagem(this);

        if (l > 0) {
            if (c > 0) {
                visao += "|" + mapa[l - 1][c - 1];
            }
            visao += "|" + mapa[l - 1][c];
            if (c + 1 < mapa[l - 1].length) {
                visao += "|" + mapa[l - 1][c + 1];
            }
            visao += "|\n";
        }
        if (c > 0) {
            visao += "|" + mapa[l][c - 1];
        }
        visao += "|" + mapa[l][c];
        if (c + 1 < mapa[l].length) {
            visao += "|" + mapa[l][c + 1];
        }
        visao += "|\n";

        if (l < mapa[l].length) {
            if (c > 0) {
                visao += "|" + mapa[l + 1][c - 1];
            }
            visao += "|" + mapa[l + 1][c];
            if (c + 1 < mapa[l + 1].length) {
                visao += "|" + mapa[l + 1][c + 1] + "|\n";
            }
        }
        return visao;
    }

    @Override
    public String toString() {
        return "P";
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
