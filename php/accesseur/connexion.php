<?php
    $hostname = "localhost";
    $databaseName = "capture";
    $port = "5432";
    
    $username = "postgres";
    $password = "9182";

    $dsn = 'pgsql:dbname='.$databaseName.';host='.$hostname.';port='.$port;
    $basededonnees = new PDO($dsn, $username, $password);
?>