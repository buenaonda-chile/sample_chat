package com.sample.chat.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "join")
public class Join {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name =  "user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;
}
