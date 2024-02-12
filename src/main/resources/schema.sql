-- Table: Conponent
CREATE TABLE Component (
                           Id integer  NOT NULL,
                           Name varchar(50)  NOT NULL,
                           CONSTRAINT Component_pk PRIMARY KEY (Id)
);

-- Table: ConponentsInRoom
CREATE TABLE ConponentsInRoom (
                                  Id integer  NOT NULL,
                                  IdRoom integer  NOT NULL,
                                  IdComponent integer  NOT NULL,
                                  CONSTRAINT ConponentsInRoom_pk PRIMARY KEY (Id)
);

-- Table: Country
CREATE TABLE Country (
                         Id integer  NOT NULL,
                         Name varchar(50)  NOT NULL,
                         CONSTRAINT IdCountry PRIMARY KEY (Id)
);

-- Table: Hotel
CREATE TABLE Hotel (
                       Id integer  NOT NULL,
                       IdTown integer  NOT NULL,
                       Name varchar(50)  NOT NULL,
                       CONSTRAINT Hotel_pk PRIMARY KEY (Id)
);

-- Table: Reservation
CREATE TABLE Reservation (
                             Id integer  NOT NULL,
                             IdUser integer  NOT NULL,
                             DateFrom date  NOT NULL,
                             DateTo date  NOT NULL,
                             IdRoom integer  NOT NULL,
                             CONSTRAINT Reservation_pk PRIMARY KEY (Id)
);

-- Table: Room
CREATE TABLE Room (
                      Id integer  NOT NULL,
                      IdTargetRoom integer  NOT NULL,
                      NrRoom integer  NOT NULL,
                      CONSTRAINT Room_pk PRIMARY KEY (Id)
);

-- Table: TargetRoom
CREATE TABLE TargetRoom (
                            Id integer  NOT NULL,
                            IdHotel integer  NOT NULL,
                            CountPeople integer  NOT NULL,
                            CountTargetRoom integer  NOT NULL,
                            CONSTRAINT TargetRoom_pk PRIMARY KEY (Id)
);

-- Table: Town
CREATE TABLE Town (
                      Id integer  NOT NULL,
                      IdCountry integer  NOT NULL,
                      Name varchar(50)  NOT NULL,
                      CONSTRAINT Town_pk PRIMARY KEY (Id)
);

-- Table: User
CREATE TABLE User (
                      Id integer  NOT NULL,
                      Name varchar(20)  NOT NULL,
                      Surname varchar(50)  NOT NULL,
                      IsWorker bool  NOT NULL,
                      CONSTRAINT User_pk PRIMARY KEY (Id)
);

-- Table: WorkerInHotel
CREATE TABLE WorkerInHotel (
                               IdWorkerInHotel integer  NOT NULL,
                               IdHotel integer  NOT NULL,
                               IdUser integer  NOT NULL,
                               IsAdmin bool  NOT NULL,
                               CONSTRAINT WorkerInHotel_pk PRIMARY KEY (IdWorkerInHotel)
);

-- foreign keys
-- Reference: ConponentInRoom_Component (table: ConponentsInRoom)
ALTER TABLE ConponentsInRoom ADD CONSTRAINT ConponentInRoom_Component FOREIGN KEY ConponentInRoom_Component (IdComponent)
    REFERENCES Component (Id);

-- Reference: ConponentInRoom_Room (table: ConponentsInRoom)
ALTER TABLE ConponentsInRoom ADD CONSTRAINT ConponentInRoom_Room FOREIGN KEY ConponentInRoom_Room (IdRoom)
    REFERENCES TargetRoom (Id);

-- Reference: Hotel_Town (table: Hotel)
ALTER TABLE Hotel ADD CONSTRAINT Hotel_Town FOREIGN KEY Hotel_Town (IdTown)
    REFERENCES Town (Id);

-- Reference: Reservation_Person (table: Reservation)
ALTER TABLE Reservation ADD CONSTRAINT Reservation_Person FOREIGN KEY Reservation_Person (IdUser)
    REFERENCES User (Id);

-- Reference: Reservation_Room (table: Reservation)
ALTER TABLE Reservation ADD CONSTRAINT Reservation_Room FOREIGN KEY Reservation_Room (IdRoom)
    REFERENCES Room (Id);

-- Reference: Room_Hotel (table: TargetRoom)
ALTER TABLE TargetRoom ADD CONSTRAINT Room_Hotel FOREIGN KEY Room_Hotel (IdHotel)
    REFERENCES Hotel (Id);

-- Reference: Room_TargetRoom (table: Room)
ALTER TABLE Room ADD CONSTRAINT Room_TargetRoom FOREIGN KEY Room_TargetRoom (IdTargetRoom)
    REFERENCES TargetRoom (Id);

-- Reference: WorkerInHotel_Country (table: Town)
ALTER TABLE Town ADD CONSTRAINT WorkerInHotel_Country FOREIGN KEY WorkerInHotel_Country (IdCountry)
    REFERENCES Country (Id);

-- Reference: WorkerInHotel_Hotel (table: WorkerInHotel)
ALTER TABLE WorkerInHotel ADD CONSTRAINT WorkerInHotel_Hotel FOREIGN KEY WorkerInHotel_Hotel (IdHotel)
    REFERENCES Hotel (Id);

-- Reference: WorkerInHotel_User (table: WorkerInHotel)
ALTER TABLE WorkerInHotel ADD CONSTRAINT WorkerInHotel_User FOREIGN KEY WorkerInHotel_User (IdUser)
    REFERENCES User (Id);