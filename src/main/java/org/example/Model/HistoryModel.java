package org.example.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HistoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:ss")
    @Column(name = "history_date")
    private Date historyDate;

    @Column(name = "history_action")
    private String historyAction;

    @Column(name = "history_description")
    private String historyDescription;

    @ManyToOne
    @JoinColumn(name = "customerModel_id")
    private ItemModel historyModel;
}
