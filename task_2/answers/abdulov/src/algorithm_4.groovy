void process() {
    BufferedReader bufferedReader = new BufferedReader(new FileReader('/home/ais/projects/algorithms/task_2/text.txt'));

    int symbol = bufferedReader.read();
    Boolean writeFlag = false;
    String testStrLeft = "";
    String testStrRight = ""; ;
    def res = [:];
    char testLeft = (char) '(';
    char testDot = (char) '.';
    char testRight = (char) ')';

    while (symbol != -1) {  // Когда дойдём до конца файла, получим '-1'
        char c = (char) symbol;
        if (c == testLeft && !writeFlag) {
            testStrLeft = "";
            testStrRight = "";
            writeFlag = true;
        }

        if (writeFlag && c == testDot) {
        } else if (writeFlag && c == testLeft) {
            testStrLeft += c;
        } else if (writeFlag && c == testRight) {
            testStrRight += c;
        } else if (writeFlag) {
            writeFlag = false;
            if (testStrLeft.length() == testStrRight.length()) {
                def tits = testStrLeft.substring(0, testStrLeft.length() - 1) + '.)(.' + testStrRight.substring(0, testStrLeft.length() - 1);
                if (res[tits])
                    res[tits] = res[tits] + 1;
                else
                    res[tits] = 1;
            }
        }

        symbol = bufferedReader.read(); // Читаем символ
    }

    res.sort().each { k, v -> println "${k}:${v}" };
}

println "Start processing";
def start = new Date();
process();
def end = new Date();
println "Time: ${end.getTime() - start.getTime()}";
