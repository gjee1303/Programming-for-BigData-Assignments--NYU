input1 = load '/user/cloudera/pigdata/input1.txt' as (line:chararray);
A = FOREACH input1 GENERATE REPLACE(line,'([^a-zA-Z,\\s]+)','') as line;
B = FOREACH A GENERATE FLATTEN(TOKENIZE((chararray)$0)) as word;
C = FILTER B BY (word matches '.*Dec.*');
D = FILTER B BY (word matches '.*Hackathon.*');
E = FILTER B BY (word matches '.*Chicago.*');
F = FILTER B BY (word matches '.*Java.*');
G = GROUP C BY word;
H = GROUP D BY word;
I = GROUP E BY word;
J = GROUP F BY word;
K = FOREACH G GENERATE group,COUNT(C);
L = FOREACH H GENERATE group,COUNT(D);
M = FOREACH I GENERATE group,COUNT(E);
N = FOREACH J GENERATE group,COUNT(F);
Result = union K,L,M,N;
STORE Result into 'output_wordcount_1';



