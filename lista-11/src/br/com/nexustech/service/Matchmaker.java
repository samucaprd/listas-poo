package br.com.nexustech.service;

import br.com.nexustech.exception.BanidoException;
import br.com.nexustech.model.ModoJogo;

public class Matchmaker {

    public void encontrarSala(ModoJogo modo, boolean jogadorBanido)
            throws BanidoException {

        if (jogadorBanido) {
            throw new BanidoException();
        }

        modo.buscarPartida();
    }
}