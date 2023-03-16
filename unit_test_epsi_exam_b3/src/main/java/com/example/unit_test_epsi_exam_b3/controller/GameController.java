package com.example.unit_test_epsi_exam_b3.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {
    private int win;
    private int lose;
    private int draw;
    @GetMapping
    public String getGame() {
        return "Hello Game !";
    }

    @GetMapping("play/{action}")
    public String playGame(@PathVariable("action") String action) {
        String computerAction = "";
        String result = "";
        int computerInt = (int) (Math.random() * 3 + 1);

        if (computerInt == 1) {
            computerAction = "rock";
        } else if (computerInt == 2) {
            computerAction = "paper";
        } else if (computerInt == 3) {
            computerAction = "scissors";
        }

        result = "Vous avez joué " + action + " et l'ordinateur a joué " + computerAction + ". Vous avez ";

        if (action.equals(computerAction)) {
            this.draw++;
            return result + "fait égalité";
        } else if (action.equals("rock")) {
            if (computerAction.equals("scissors")) {
                this.win++;
                return result + "gagné";
            } else {
                this.lose++;
                return result + "perdu";
            }
        } else if (action.equals("paper")) {
            if (computerAction.equals("rock")) {
                this.win++;
                return result + "gagné";
            } else {
                this.lose++;
                return result + "perdu";
            }
        } else if (action.equals("scissors")) {
            if (computerAction.equals("paper")) {
                this.win++;
                return result + "gagné";
            } else {
                this.lose++;
                return result + "perdu";
            }
        } else {
            return "Erreur";
        }
    }
    @GetMapping("score")
    public String getScore() {
        return "Vous avez gagné " + this.win + " fois, perdu " + this.lose + " fois et fait égalité " + this.draw + " fois.";
    }

    @PostMapping("restart")
    public String restartGame() {
        this.win = 0;
        this.lose = 0;
        this.draw = 0;
        return "Réinitialisation";
    }

    @PutMapping("score/{win}/{lose}/{draw}")
    public String updateScore(@PathVariable("win") int win, @PathVariable("lose") int lose, @PathVariable("draw") int draw) {
        this.win = win;
        this.lose = lose;
        this.draw = draw;
        return "Mise à jour du score";
    }
}
