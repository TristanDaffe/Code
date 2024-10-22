create table mutuelle(
    id int identity primary key ,
    nom varchar(250) not null,
    adresse varchar(250) not null,
    email varchar(250) not null
);
-- DF:
-- mutuelle(id, nom, adresse, email)
-- id -> nom
-- id -> adresse
-- id -> email
-- 1NF: ok
-- 2NF: ok
-- 3NF: ok (si pas email pas unique, ce qui est discutable)




-- Si email unique, alors l'email peut remplacer id

create table domicile(
    id int identity primary key ,
    adresse varchar(250) not null
);

-- DF: domicile(id, adresse)
-- id -> adresse
-- 1NF: ok
-- 2NF: ok
-- 3NF: ok

create table personne(
    id int identity primary key,
    nom varchar(250) not null,
    prenom varchar(250) not null
);

-- DF: personne(id, nom, prenom)
-- id -> nom
-- id -> prenom
-- 1NF: ok
-- 2NF: ok
-- 3NF: ok

create table categorie(
    id int identity primary key,
    nom_fr varchar(250) not null,
    nom_nl varchar(250),
    nom_ge varchar(250)
);

-- DF: categorie(id, nom_fr, nom_nl, nom_ge)
-- id -> nom_fr
-- id -> nom_nl
-- id -> nom_ge
-- 1NF: ok
-- 2NF: ok
-- 3NF: ok


create table patient(
    id int references personne(id) primary key,
    mutuelle int references mutuelle(id),
    categorie int references categorie(id)
);

-- DF: patient
-- id -> mutuelle
-- id -> categorie
-- 1NF: ok
-- 2NF: ok
-- 3NF: ok

create table personne_domicile(
    personne_id int references personne(id),
    domicile_id int references domicile(id),
    date_insertion date not null default GETDATE(),
    PRIMARY KEY (personne_id, date_insertion)
);

--DF: personne_domicile
-- personne_id, date_insertion --> domicile_id
-- 1NF: ok
-- 2NF: ok
-- 3NF: ok

create table employeur(
    id int identity primary key,
    nom varchar(250) not null
);

-- DF: employeur
-- id -> nom
-- 1NF: ok
-- 2NF: ok
-- 3NF: ok

create table employeur_montant_tarifaire(
    employeur_id int references employeur(id),
    montant_tarifaire decimal not null,
    numero_passage smallint not null check ( numero_passage > 0 AND numero_passage < 4 ),
    PRIMARY KEY (employeur_id, numero_passage),
    UNIQUE (employeur_id, montant_tarifaire)
);

-- DF: employeur_montant_tarifaire
-- employeur_id, numero_passage --> montant_tarifaire
-- 1NF: ok
-- 2NF: ok
-- 3NF: ok

create table vehicule(
    type varchar(250) primary key,
    frais_par_km decimal not null
);

-- DF: vehicule
-- type -> frais_par_km
-- 1NF: ok
-- 2NF: ok
-- 3NF: ok

create table infirmiere(
    id int references personne(id) primary key ,
    coordonnes_bancaires varchar(250) not null UNIQUE,
    vehicule varchar(250) references vehicule(type),
    employeur_id int references employeur(id)
);

--DF: infirmiere
-- id --> coordonnes_bancaires
-- id --> vehicule
-- id --> employeur_id
-- 1NF: ok
-- 2NF: ok
-- 3NF: NON




-- coordonnes_bancaires --> employeur_id
-- coordonnes_bancaires --> vehicule

-- Sauf si comptes communs (il faut faire sauter la contrainte unique)
create table trajet(
    id int identity primary key,
    km_parcourus decimal not null,
    point_depart int references personne(id),
    point_arrive int references personne(id),
    date_heure datetime2 not null
);

-- DF: trajet
-- id -> km_parcourus
-- id -> point_depart
-- id -> point_arrive
-- id -> date_heure
-- 1NF: ok
-- 2NF: ok
-- 3NF: ok

create table soin(
    id int identity primary key,
    rubrique varchar(250),
    nom_fr varchar(250) not null,
    nom_nl varchar(250),
    nom_ge varchar(250)
);

--DF: soin
-- id -> rubrique
-- id -> nom_fr
-- id -> nom_nl
-- id -> nom_ge
-- 1NF: ok
-- 2NF: ok
-- 3NF: ok

create table infirmiere_soin(
    infirmiere_id int references infirmiere(id),
    soin_id int references soin(id),
    PRIMARY KEY (infirmiere_id, soin_id)
);

--DF: infirmiere_soin
-- infirmiere_id, soin_id --> infirmire_id
-- infirmiere_id, soin_id --> soin_id
-- 1NF: ok
-- 2NF: ok
-- 3NF: ok

create table medecin(
    id int references personne(id) PRIMARY KEY
);
-- DF: medecin
-- id --> id
-- 1NF: ok
-- 2NF: ok
-- 3NF: ok

create table prescription(
    id int identity primary key,
    duree varchar(250) not null,
    frequence varchar(250) not null,
    patient_id int references patient(id),
    medecin_id int references medecin(id),
    CHECK  (patient_id != medecin_id)
);

-- DF: prescription
-- id -> duree
-- id -> frequence
-- id -> patient_id
-- id -> medecin_id
-- 1NF: ok
-- 2NF: ok
-- 3NF: ok

create table tarification(
    annee int not null,
    soin_id int references soin(id),
    categorie_id int references categorie(id),
    prix DECIMAL not null,
    PRIMARY KEY (soin_id, annee, categorie_id)
);
-- DF tarification
-- soin_id, annee, categorie_id --> soin_id
-- soin_id, annee, categorie_id --> annee
-- soin_id, annee, categorie_id --> categorie_id
-- soin_id, annee, categorie_id --> prix
-- 1NF: ok
-- 2NF: ok
-- 3NF: ok

create table prestation(
    id int identity primary key,
    patient_id int references patient(id),
    "date" date not null
);

-- DF prestation
-- id -> patient_id
-- id -> date
-- 1NF: ok
-- 2NF: ok
-- 3NF: ok

CREATE TABLE prestation_infirmiere(
    prestation_id int REFERENCES prestation(id),
    infirmiere_id int REFERENCES infirmiere(id),
    numero_passage_journalier smallint not null CHECK ( numero_passage_journalier > 0 AND numero_passage_journalier < 4 ),
    PRIMARY KEY (prestation_id, infirmiere_id, numero_passage_journalier)
);

-- DF prestation_infirmiere
-- prestation_id, infirmiere_id, numero_passage_journalier --> prestation_id
-- prestation_id, infirmiere_id, numero_passage_journalier --> infirmiere_id
-- prestation_id, infirmiere_id, numero_passage_journalier --> numero_passage_journalier
-- 1NF: ok
-- 2NF: ok
-- 3NF: ok

create table prestation_soin(
    prestation_id int references prestation(id),
    soin_id int references soin(id),
    primary key (prestation_id, soin_id)
);

-- DF prestation_soin
-- prestation_id, soin_id --> prestation_id
-- prestation_id, soin_id --> soin_id
-- 1NF: ok
-- 2NF: ok
-- 3NF: ok

create table facture(
    numero int identity,
    annee int not null,
    primary key (numero, annee)
);

-- DF facture
-- numero, annee --> numero
-- numero, annee --> annee
-- 1NF: ok
-- 2NF: ok
-- 3NF: ok

create table rejet_de_facture(
    numero int not null,
    annee int not null,
    prestation_id int references prestation(id),
    raison varchar(250) not null,
    foreign key (numero, annee) references facture(numero, annee),
    primary key (numero, annee, prestation_id)
);

-- DF rejet_de_facture
-- numero, annee, prestation_id --> raison
-- 1NF: ok
-- 2NF: ok
-- 3NF: ok

-- Trigger prix dégressif
CREATE trigger montant_forfaitaire_degressif
ON employeur_montant_tarifaire
AFTER INSERT, UPDATE
AS BEGIN
    SET NOCOUNT ON;
    DECLARE
        @employeur_id int,
        @montant_tarifaire decimal,
        @numero_passage smallint
    SELECT @employeur_id = inserted.employeur_id,
           @montant_tarifaire = inserted.montant_tarifaire,
           @numero_passage = inserted.numero_passage
    FROM inserted
    IF EXISTS (SELECT * FROM employeur_montant_tarifaire WHERE employeur_id = @employeur_id AND numero_passage < @numero_passage AND montant_tarifaire < @montant_tarifaire)
        BEGIN
            RAISERROR (N'Le montant tarifaire doit être dégressif', 10, 1);
            ROLLBACK TRANSACTION;
            RETURN;
        END;
END;

--Trigger passage avec tarification existante
CREATE TRIGGER tarification_existante ON prestation
AFTER INSERT, UPDATE
AS
    BEGIN
        SET NOCOUNT ON;
        DECLARE
            @patient_id int
        SELECT @patient_id = patient_id FROM inserted
        IF NOT EXISTS (
            SELECT * FROM prestation p
            JOIN prestation_soin ps on ps.prestation_id = p.id
            JOIN patient p2 on p.patient_id = p2.id
            JOIN tarification t on p2.categorie = t.categorie_id
            WHERE t.annee = YEAR(p.date)
              AND t.soin_id = ps.soin_id
              AND p2.id = @patient_id
            )
            BEGIN
                RAISERROR (N'Aucune tarification pour cette année et ce soin', 10, 1);
                ROLLBACK TRANSACTION;
                RETURN;
            END
    END


CREATE TRIGGER trajet_successif ON trajet
AFTER INSERT, UPDATE
AS
    BEGIN
        SET NOCOUNT ON;
        DECLARE
            @date_heure datetime2,
            @point_depart int
        SELECT @date_heure = date_heure, @point_depart = point_depart FROM inserted
        IF NOT EXISTS(
            SELECT * FROM trajet
            WHERE datediff(day, trajet.date_heure, @date_heure) = 0 AND
                  trajet.date_heure < @date_heure AND
                  trajet.point_arrive = @point_depart
            )
            BEGIN
                RAISERROR (N'Le trajet ne suit pas le précédent', 10, 1);
                ROLLBACK TRANSACTION;
                RETURN;
            END
    END

-- Trigger: Rubrique pour soin obligatoire uniquement si au moins une infimière le pratique
CREATE TRIGGER rubrique_necessaire ON infirmiere_soin
AFTER INSERT, UPDATE
AS
    BEGIN
        SET NOCOUNT ON;
        DECLARE
            @soin_id int
        SELECT @soin_id = soin_id FROM inserted
        IF NOT EXISTS( SELECT * FROM soin WHERE id = @soin_id)
            BEGIN
                RAISERROR (N'Il faut une rubrique pour que le soin soit praticable', 10, 1);
                ROLLBACK TRANSACTION;
                RETURN;
            END
    END

-- Trigger: Une rubrique ne peut pas être supprimée.
CREATE TRIGGER protege_rubrique ON soin
AFTER UPDATE
AS
    BEGIN
        SET NOCOUNT ON;
        IF EXISTS(SELECT * FROM inserted WHERE inserted.rubrique IS NULL)
            BEGIN
                 RAISERROR (N'Une rubrique ne peut pas être supprimée', 10, 1);
                 ROLLBACK TRANSACTION;
                 RETURN;
            END
    END

-- Trigger: une infirmière ne peut pas être son propre patient
CREATE TRIGGER infirmiere_prestation_patient ON prestation
AFTER INSERT, UPDATE
AS
    BEGIN
        SET NOCOUNT ON;
        DECLARE
            @patient_id int
        SELECT @patient_id=patient_id FROM inserted
        IF EXISTS(
            SELECT * FROM prestation p
            JOIN prestation_infirmiere pi on p.id = pi.prestation_id
            WHERE @patient_id = pi.infirmiere_id
            )
            BEGIN
                RAISERROR (N'Une infirmière ne peut pas être son propre patient', 10, 1);
                ROLLBACK TRANSACTION;
                RETURN;
            END
    END


-- Trigger pour --> restart séquence facture chaque année (impossible)
-- Il faut un job planifié pour cela

/*To create a SQL Server Agent job

    1) Execute sp_add_job to create a job.
    2) Execute sp_add_jobstep to create one or more job steps.
    3) Execute sp_add_schedule to create a schedule.
    4) Execute sp_attach_schedule to attach a schedule to the job.
    5) Execute sp_add_jobserver to set the server for the job.

  source: https://docs.microsoft.com/en-us/previous-versions/sql/sql-server-2008-r2/ms181153(v=sql.105)?redirectedfrom=MSDN
*/
-- Besoin de la permission EXEC pour le code suivant
-- 1
USE msdb ;
GO
EXEC sp_add_job 'Reset numero facture'

-- 2
EXEC sp_add_jobstep
    @job_name = 'Reset numero facture',
    @step_name = 'Reset',
    @command = N'DBCC Checkident ( facture, RESEED, 0)'

-- 3
EXEC sp_add_schedule
     @schedule_name = N'Premier jour annee',
     @freq_type = 16,
     @freq_interval = 1,
     @freq_recurrence_factor = 12,
     @active_start_date = 20220101

-- 4
EXEC sp_attach_schedule
    @job_name = N'Reset numero facture',
    @schedule_name = N'Premier jour annee'

-- 5
EXEC sp_add_jobserver
    @job_name = N'Reset numero facture'