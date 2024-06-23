
    public class JogadorTruco extends Jogador {

        public JogadorTruco(String nome) {
            super(nome);
        }
    
        @Override
        public Carta jogada(Carta cartaNaMesa) {
            // Se não há carta na mesa, joga a carta de maior valor
            if (cartaNaMesa == null) {
                return jogarMaiorCarta();
            }
    
            // Tenta jogar uma carta que ganhe da carta na mesa, se possível
            for (Carta carta : cartas) {
                if (carta.valor > cartaNaMesa.valor) {
                    return jogarCarta(carta);
                }
            }
    
            // Se não tiver carta para ganhar, joga a carta de menor valor
            return jogarMenorCarta();
        }
    
        private Carta jogarMaiorCarta() {
            Carta maiorCarta = cartas.get(0);
            for (Carta carta : cartas) {
                if (carta.valor > maiorCarta.valor) {
                    maiorCarta = carta;
                }
            }
            cartas.remove(maiorCarta);
            return maiorCarta;
        }
    
        private Carta jogarMenorCarta() {
            Carta menorCarta = cartas.get(0);
            for (Carta carta : cartas) {
                if (carta.valor < menorCarta.valor) {
                    menorCarta = carta;
                }
            }
            cartas.remove(menorCarta);
            return menorCarta;
        }
    
        private Carta jogarCarta(Carta carta) {
            cartas.remove(carta);
            return carta;
        }
    }

    

