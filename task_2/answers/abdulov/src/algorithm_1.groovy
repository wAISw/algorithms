void process() {
    def text = new File('/home/ais/projects/algorithms/task_2/text.txt').text;
    def titsMap = text.split(/[\w\s\,\.]/);
    def res = [:];
    for (i = 0; i < titsMap.length; i++) {
        if (titsMap[i] == ")(" && titsMap[i - 1].length() == titsMap[i + 1].length()) {
            if (res["${titsMap[i - 1]}.${titsMap[i]}.${titsMap[i + 1]}"])
                res["${titsMap[i - 1]}.${titsMap[i]}.${titsMap[i + 1]}"] = res["${titsMap[i - 1]}.${titsMap[i]}.${titsMap[i + 1]}"] + 1;
            else
                res["${titsMap[i - 1]}.${titsMap[i]}.${titsMap[i + 1]}"] = 1;
        }
    }

    res.sort().each { k, v -> println "${k}:${v}" };
}

println "Start processing";
def start = new Date();
process();
def end = new Date();
println "Time: ${end.getTime() - start.getTime()}";
