void process() {
    def text = new File('/home/ais/projects/algorithms/task_2/text.txt').text;
    def titsMap = text.findAll(/\(*\.\)\(.\)*/);
    def res = [:];

    titsMap.sort().each { tits ->
        if (tits.findAll(/\(/).size() == tits.findAll(/\)/).size())
            if (res[tits])
                res[tits] = res[tits] + 1;
            else
                res[tits] = 1;
    };

    res.sort().each { k, v -> println "${k}:${v}" };
}

println "Start processing";
def start = new Date();
process();
def end = new Date();
println "Time: ${end.getTime() - start.getTime()}";
