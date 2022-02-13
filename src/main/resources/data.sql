--VIRAL_FAMILY
INSERT INTO VIRAL_FAMILY (ID,NAME,DESCRIPTION) VALUES (1, 'Adenoviridae','Adenoviruses (members of the family Adenoviridae) are medium-sized (90–100 nm), nonenveloped (without an outer lipid bilayer) viruses with an icosahedra...');
INSERT INTO VIRAL_FAMILY (ID,NAME,DESCRIPTION) VALUES (2, 'Papillomaviridae','Papillomaviridae is a family of non-enveloped DNA viruses whose members are known as papillomaviruses.Several hundred species of papillomaviruses, traditionally...');
INSERT INTO VIRAL_FAMILY (ID,NAME,DESCRIPTION) VALUES (3, 'Herpesviridae','Herpesviridae is a large family of DNA viruses that cause infections and certain diseases in animals, including humans.[1][2][3] The members of this family are also known ...');

--VIRUS
INSERT INTO VIRUS (ID, NAME, LINEAGE, GENOME_TYPE, VIRAL_FAMILY_ID) VALUES (1, 'Avirulent turkey hemorrhagic enteritis virus',
 'Viruses; Varidnaviria; Bamfordvirae;Preplasmiviricota; Tectiliviricetes; Rowavirales;Adenoviridae; Siadenovirus;Turkey siadenovirus A',
 'Non-segmented', 1);
 INSERT INTO VIRUS (ID, NAME, LINEAGE, GENOME_TYPE, VIRAL_FAMILY_ID) VALUES (2, 'Ailuropoda melanoleuca papillomavirus 1',
 'Viruses; Monodnaviria; Shotokuvirae; Cossaviricota;Papovaviricetes; Zurhausenvirales;Papillomaviridae; Firstpapillomavirinae;Omegapapillomavirus; Omegapapillomavirus',
 'Non-segmented', 2);
 INSERT INTO VIRUS (ID, NAME, LINEAGE, GENOME_TYPE, VIRAL_FAMILY_ID) VALUES (3, 'Apodemus sylvaticus papillomavirus 1',
 'Viruses; Monodnaviria; Shotokuvirae; Cossaviricota; Papovaviricetes; Zurhausenvirales; Papillomaviridae; Firstpapillomavirinae; Pipapillomavirus; Pipapillomavirus 2',
 'Non-segmented', 3);

--HOST
INSERT INTO HOST (ID, NAME, LINEAGE) VALUES (1, 'Phasianus colchicus',
'cellular organisms; Eukaryota; Opisthokonta; Metazoa; Eumetazoa; Bilateria; Deuterostomia; Chordata; Craniata; Vertebrata; Gnathostomata; Teleostomi; Euteleostomi; Sarcopterygii; Dipnotetrapodomorpha; Tetrapoda; Amniota; Sauropsida; Sauria; Archelosauria;');
INSERT INTO HOST (ID, NAME, LINEAGE) VALUES (2, 'Ailuropoda melanoleuca',
'cellular organisms; Eukaryota; Opisthokonta; Metazoa; Eumetazoa; Bilateria; Deuterostomia; Chordata; Craniata; Vertebrata; Gnathostomata; Teleostomi; Euteleostomi; Sarcopterygii; Dipnotetrapodomorpha; Tetrapoda; Amniota;');
INSERT INTO HOST (ID, NAME, LINEAGE) VALUES (3, 'Apodemus sylvaticus',
'cellular organisms; Eukaryota; Opisthokonta; Metazoa; Eumetazoa; Bilateria; Deuterostomia; Chordata; Craniata; Vertebrata; Gnathostomata; Teleostomi; Euteleostomi; Sarcopterygii; Dipnotetrapodomorpha; Tetrapoda;');

--VIRUS_HOST
INSERT INTO VIRUS_HOST (VIRUS_ID, HOST_ID) VALUES (1, 1);
INSERT INTO VIRUS_HOST (VIRUS_ID, HOST_ID) VALUES (2, 2);
INSERT INTO VIRUS_HOST (VIRUS_ID, HOST_ID) VALUES (3, 3);