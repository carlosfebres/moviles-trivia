package uru.ing.computacion.moviles.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="game", schema = "public")
public class Game {

	@Id
	@GeneratedValue
	private int id;

	private int score = 0;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "player_id")
	private User player;

	@CreationTimestamp
	private LocalDateTime created_at;

	Game() {}
	Game(int id) {this.setId(id);}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public User getPlayer() {
		return player;
	}

	public void setPlayer(User player) {
		this.player = player;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
}
