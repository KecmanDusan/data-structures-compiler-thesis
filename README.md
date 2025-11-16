# data-structures-compiler-thesis
Strukture podataka u internim reprezentacijama softvera i metamodelima
Repozitorijum za seminarski rad - Prirodno-matematički fakultet, Univerzitet u Novom Sadu
Student: Dušan Kecman
Broj indeksa: 139/22
Godina: 2025
Sadržaj
Ovaj repozitorijum sadrži implementacije i benchmark testove za seminarski rad koji analizira strukture podataka korišćene u:

Apstraktnim sintaksnim stablima (AST)
Grafovima toka kontrole (CFG)
Simboličkim tabelama

Struktura repozitorijuma
data-structures-compiler-thesis/
├── README.md
├── benchmarks/
│   ├── ASTBenchmark.java
│   ├── GraphBenchmark.java
│   └── SymbolTableBenchmark.java
├── src/
│   ├── ast/
│   │   ├── oop/
│   │   ├── visitor/
│   │   └── data/
│   ├── graph/
│   └── symboltable/
├── results/
└── paper/
Kako pokrenuti testove
Kompilacija i pokretanje
bash# Kreiraj bin folder
mkdir -p bin

# AST Benchmark
javac -d bin benchmarks/ASTBenchmark.java src/ast/oop/*.java src/ast/visitor/*.java src/ast/data/*.java
java -cp bin -Xmx2G ASTBenchmark

# Graph Benchmark  
javac -d bin benchmarks/GraphBenchmark.java src/graph/*.java
java -cp bin GraphBenchmark

# SymbolTable Benchmark
javac -d bin benchmarks/SymbolTableBenchmark.java src/symboltable/*.java
java -cp bin SymbolTableBenchmark
Rezultati
Svi rezultati se automatski prikazuju na konzoli u tabelarnom formatu.
Ključni nalazi:
AST implementacije (1023 čvora):

OOP: 385ms, 768KB
Visitor: 571ms, 816KB
Data-oriented: 279ms, 544KB

Grafovi (1000 čvorova, 1000 iteracija):

Matrica: 1847ms, 976KB
Lista: 2ms, 22KB

Simboličke tabele (1000 simbola):

Linearna lista: 48ms pretraživanje
Heš tabela: 1.6ms pretraživanje
