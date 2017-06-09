<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>About NerdBook</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Giorgia Campanile">
        <meta name="keywords" content="NerdBook descrizione dettagli">
        
        <link rel="stylesheet" type="text/css" href="M3/style.css" media="screen">
        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/javascript.js"></script>
    </head>
    
    <body>
        <div id="page">
            <header>
                <div id="title">
                    <h1>NerdBook</h1>
                </div>
                <nav class = "navLeft">
                    <ul>
                        <li><a href="bacheca.html">Bacheca</a></li>
                        <li><a class="sonoQui" href="descrizione.html">Descrizione</a></li>
                        <li><a href="profilo.html">Profilo</a></li>
                    </ul>
                </nav>
                <nav class="navRight">
                    <ul><li><a href="login.html">Login</a></li></ul>
                </nav>
            </header>
   
            <div id="navBarInterna">
                <ol>
                    <li><a href="#divHistory">Storia</a>
                        <ul>
                            <li><a href="#nasc">Nascita</a></li>
                            <li><a href="#esor">Esordio</a></li>
                        </ul>
                    </li>
                    <li><a href="#chisiamo">Chi siamo</a>
                        <ul>
                            <li><a href="#pers">Personale</a></li>
                            <li><a href="#prev">Previsioni team</a></li>
                        </ul>
                    </li>
                    <li><a href="#Gratuito">Gratuito</a></li>
                    <li><a href="#Iscriversi">Come iscriversi</a>
                        <ul>
                            <li><a href="#istr">Istruzioni</a></li>
                            <li><a href="#note">Note legali</a></li>
                        </ul>
                    </li>
                </ol>
            </div>

            <div id="divBody">
                <div id="divHistory">
                    <h2>Storia</h2>
                    <h3 id="nasc">Nascita</h3>
                    <p> NerdBook nasce il primo gennaio 2016 in seguito alla sperimentazione di alcuni studenti Cagliaritani. 
                        Inizialmente Ã¨ stato creato quasi per gioco, per la semplice curiositÃ  di creare pagine HTML e coinvolgere
                        le persone vicine. Pian piano si diffuse a macchia d'olio tra studenti, parenti, amici vicini e lontani.
                    </p>
                    <h3 id="esor">Esordio</h3>
                    <p> Il boom di utilizzi si ebbe appena tre mesi dopo, quando gli studenti scoprirono che il loro social era arrivato 
                        fino all'Inghilterra, e contava allora circa 30.000 iscritti.
                    </p>
                </div>
                <div id="chiSiamo">
                    <h2>Chi siamo</h2>
                    <h3 id ="pers">Personale</h3>
                    <p>
                        Il team di NerdBook Ã¨ attualmente composto dai creatori Giorgia Campanile e Djanni Ilgatto, entrambi studenti del corso 
                        di Laurea in Informatica a Cagliari, e da alcuni studenti che si occupano di gestire la traduzione delle pagine in altre
                        lingue e di controllare l'aspetto legale del sito.
                    </p>
                    <h3 id="prev">Previsioni team</h3>
                    <p>
                        Il team, come il Social, Ã¨ in continua crescita, e si prevede di raggiungere un vasto personale entro la fine del 2017.
                        Alcuni studenti sono giÃ  stati selezionati con successo!
                    </p>
                </div>
                <div id="Gratuito">
                    <h2>Gratuito</h2>
                    <p>
                        Ti starai chiedendo se NerdBook sia a pagamento: sbagliato! NerdBook Ã¨ un social network completamente
                        gratuito, che ti permetterÃ  di chattare e condividere le tue giornate con i tuoi amici. Cosa aspetti? Iscriviti subito!
                    </p>
                </div>
                <div id="Iscriversi">
                    <h2>Come iscriversi</h2>
                    <h3 id="istr">Istruzioni</h3>
                    <p>
                        Iscriversi Ã¨ davvero semplice: inserisci nella pagina blabla i tuoi dati personali, la tua e-mail,
                        scegli una password e... fatto! Buon divertimento!
                    </p>
                    <h3 id="note">Note legali</h3>
                    <p>
                        Per iscriversi Ã¨ necessario aver compiuto i 14 anni di etÃ .
                    </p>
                </div>
            </div>
        </div>
    </body>
</html>

