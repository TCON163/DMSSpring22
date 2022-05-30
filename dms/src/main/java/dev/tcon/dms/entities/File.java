package dev.tcon.dms.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class File {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "appFileName")
    private String appFileName;

    @Column(name = "fileName")
    private String fileName;


    @Column(name = "fileType")
    private String fileType;

    @Column(name = "folder")
    private String folder;

    @Column(name = "subfolder")
    private String subfolder;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    private DataFile dataFile;

    @ManyToOne
    @JoinColumn(name = "submissionFolderId", nullable = false)
    private SubmissionFolder submissionFolder;



}