package ga.rugal.fridge.core.entity;

import static config.SystemDefaultProperty.SCHEMA;

import java.time.Instant;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * Tag entity.
 *
 * @author sally
 */
@Data
@Entity
@Table(name = "tag", schema = SCHEMA)
public class Tag {

  private static final String SEQUENCE_NAME = "tag_tid_seq";

  @Basic(optional = false)
  @Column(name = "tid")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
  @Id
  @SequenceGenerator(name = SEQUENCE_NAME, allocationSize = 1,
          sequenceName = SCHEMA + "." + SEQUENCE_NAME)

  private Integer tid;

  @Size(max = 50)
  @Column(name = "name")
  private String name;

  @Column(name = "create_at")
  private Long createAt;

  @Column(name = "update_at")
  private Long updateAt;

  @OneToMany(mappedBy = "tag")
  private List<ItemTag> itemTagList;

  @PrePersist
  void onCreate() {
    this.createAt = Instant.now().getEpochSecond();
  }

  @PreUpdate
  void onUpdate() {
    this.updateAt = Instant.now().getEpochSecond();
  }
}
