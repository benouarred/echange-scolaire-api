CREATE TABLE echange.personne
(
   id                INT(20) NOT NULL AUTO_INCREMENT,
   nom               VARCHAR(500)
                       CHARACTER SET utf8mb4
                       COLLATE utf8mb4_general_ci
                       NOT NULL,
   prenom            VARCHAR(500)
                       CHARACTER SET utf8mb4
                       COLLATE utf8mb4_general_ci
                       NULL
                       DEFAULT 'NULL',
   date_naissance    DATE NOT NULL,
   email             VARCHAR(100)
                       CHARACTER SET utf8mb4
                       COLLATE utf8mb4_general_ci
                       NOT NULL,
   tel1              VARCHAR(20)
                       CHARACTER SET utf8mb4
                       COLLATE utf8mb4_general_ci
                       NOT NULL,
   tel2              VARCHAR(20)
                       CHARACTER SET utf8mb4
                       COLLATE utf8mb4_general_ci
                       NULL
                       DEFAULT 'NULL',
   adresse           VARCHAR(500)
                       CHARACTER SET utf8mb4
                       COLLATE utf8mb4_general_ci
                       NOT NULL,
   type              ENUM('parent', 'eleve')
                       CHARACTER SET utf8mb4
                       COLLATE utf8mb4_general_ci
                       NULL
                       DEFAULT 'NULL',
   photo             TINYBLOB NULL DEFAULT NULL,
   id_pere           INT(20) NULL DEFAULT NULL,
   id_mere           INT(20) NULL DEFAULT NULL,
   CONSTRAINT `parent_FK` FOREIGN KEY(id_pere)
      REFERENCES personne (id) ON UPDATE RESTRICT ON DELETE RESTRICT,
   PRIMARY KEY(id)
)
ENGINE INNODB
COLLATE 'utf8mb4_general_ci'
ROW_FORMAT DEFAULT;