Climate Monitoring App

Descrizione

Climate Monitoring è un sistema di monitoraggio dei parametri climatici fornito sul territorio italiano. Questa applicazione è progettata per rendere disponibili dati relativi a parametri climatici per zone di interesse, sia per gli operatori ambientali che per i comuni cittadini. La soluzione proposta offre tre moduli principali: clientCM, serverCM, e shared.
Funzionalità
1. Modulo Client (clientCM)

Il modulo client (clientCM) consente agli utenti di visualizzare i dati climatici in forma aggregata relativi alla zona geografica ricercata. Le principali funzionalità includono:

    Visualizzazione aggregato delle rilevazioni climatiche per una specifica Area Geografica.
    Selezione della zona di interesse tramite ricerca per coordinate o per denominzazione.
    Login per Operatori climatici di un Centro di Monitoraggio
    Gli operatori saranno in grado di aggiungere aree al proprio centro o rilevazioni climatiche alle aree monitorate dal proprio centro.
    Registrazione di nuovi Centri di Monitoraggio e Nuovi Operatori.

2. Modulo Server (serverCM)

Il modulo server (serverCM) gestisce la raccolta e l'archiviazione dei dati climatici provenienti dagli inserimenti degli operatori registrati. Le sue principali funzionalità includono:

    Accettazione e elaborazione dei dati climatici provenienti dagli inserimenti degli Operatori Registrati a Climate Monitoring.
    Archiviazione sicura e efficiente dei dati climatici.
    Fornitura di API per consentire l'accesso ai dati da parte dei client.
    Fornitura dell'interfaccia al DBMS e database PostgreSQL.

3. Modulo Shared

Il modulo shared contiene le risorse e le librerie condivise tra il modulo client e il modulo server. Questo approccio consente una maggiore modularità e facilità di manutenzione dell'applicazione.
Requisiti di Sistema

    Java 8 o superiore, preferibilmente 17.
    PostgreSQL 16.
    Altre dipendenze specifiche, consultare la documentazione dei singoli moduli.

Installazione

Clonare la repository.

Seguire le istruzioni riportate nel Manuale Utente e/o nel Manuale Tecnico.

Contributi

Siamo entusiasti di accogliere contributi dalla community! Per informazioni su come contribuire, richiedete un pull aprite un issue post.

Nota: Assicurarsi di consultare la documentazione specifica per ciascun modulo (clientCM, serverCM, shared) per ulteriori dettagli e istruzioni di configurazione.
