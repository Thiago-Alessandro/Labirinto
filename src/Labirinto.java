public class Labirinto {

    private final String[][] mapa = new String[11][10];
    private final Personagem personagem;

    public Labirinto(Personagem personagem) {
        this.personagem = personagem;
        setMapaLabirinto();
    }

    public String[][] getMapa() {
        return mapa;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    private void setMapaLabirinto() {
        for (int c = 0; c < 10; c++) {
            for (int l = 0; l < 11; l++) {

                switch (c) {
                    case 0 -> {
                        mapa[l][c] = "#";
                        if (l == 9) {
                            mapa[l][c] = "L";
                        }
                    }
                    case 1 -> {
                        mapa[l][c] = " ";
                        if (l == 4 || l == 6 || l == 8) {
                            mapa[l][c] = "#";
                        }
                        if (l == 0) {
                            mapa[l][c] = personagem.toString();
                        }
                    }
                    case 2 -> {
                        mapa[l][c] = "#";
                        if (l == 1 || l == 3 || l == 5 || l == 7 || l == 10) {
                            mapa[l][c] = " ";
                        }
                    }
                    case 3 -> {
                        mapa[l][c] = " ";
                        if (l == 0 || l == 2 || l == 3 || l == 4 || l == 6) {
                            mapa[l][c] = "#";
                        }
                    }
                    case 4 -> {
                        mapa[l][c] = " ";
                        if (l == 0 || l == 6 || l == 10) {
                            mapa[l][c] = "#";
                        }
                    }
                    case 5 -> {
                        mapa[l][c] = "#";
                        if (l == 1 || l == 7 || l == 9) {
                            mapa[l][c] = " ";
                        }
                    }
                    case 6 -> {
                        mapa[l][c] = " ";
                        if (l == 0 || l == 8 || l == 10) {
                            mapa[l][c] = "#";
                        }
                    }
                    case 7 -> {
                        mapa[l][c] = "#";
                        if (l == 1 || l == 9) {
                            mapa[l][c] = " ";
                        }
                    }
                    case 8 -> {
                        mapa[l][c] = " ";
                        if (l == 0 || l == 6 || l == 7 || l == 8 || l == 10) {
                            mapa[l][c] = "#";
                        }
                        if (l == 5) {
                            mapa[l][c] = "K";
                        }
                    }
                    case 9 -> {
                        mapa[l][c] = "#";
                        if (l == 1 || l == 7 || l == 8 | l == 9) {
                            mapa[l][c] = " ";
                        }
                    }
                }
            }
        }
    }

    public String mostrarLabirinto() {
        StringBuilder mapaCordenadas = new StringBuilder();
        for (int l = 0; l < 11; l++) {
            for (int c = 0; c < 10; c++) {
                mapaCordenadas.append("|").append(mapa[l][c]);
            }
            mapaCordenadas.append("|\n");
        }
        return mapaCordenadas.toString();
    }

    public Integer getColunaPersonagem(Personagem personagem) {
        for (int l = 0; l < 11; l++) {
            for (int c = 0; c < 10; c++) {
                if (mapa[l][c].equals(personagem.toString())) {
                    return c;
                }
            }
        }
        return null;
    }

    public Integer getLinhaPersonagem(Personagem personagem) {
        for (int l = 0; l < 11; l++) {
            for (int c = 0; c < 10; c++) {
                if (mapa[l][c].equals(personagem.toString())) {
                    return l;
                }
            }
        }
        return null;
    }

    public boolean checarCaminhoLivre(int l, int c){
        if (l >= 0 && l < mapa.length &&
                c >= 0 && c < mapa[l].length) {
            switch (mapa[l][c]){
                case "K" -> personagem.pegarChave(this);
                case "#" -> throw new CaminhoObstruidoException();
                case "L" -> throw new SaidaTrancadaException();
            }
            return true;
        }
        return false;
    }

    public boolean personagemNaSaida() {
        for (int l = 0; l < 11; l++) {
            for (int c = 0; c < 10; c++) {
                if (mapa[l][c].equals("E") || mapa[l][c].equals("L")) {
                    return false;
                }
            }
        }
        return true;
    }

    public void liberarSaida() {
        for (int l = 0; l < 11; l++) {
            for (int c = 0; c < 10; c++) {
                if (mapa[l][c].equals("L")) {
                    mapa[l][c] = "E";
                }
                if (mapa[l][c].equals("K")) {
                    mapa[l][c] = " ";
                }
            }
        }
    }
}
