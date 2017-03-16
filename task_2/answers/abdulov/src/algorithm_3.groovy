void process() {
    def text = new File('/home/ais/projects/algorithms/task_2/text.txt').text;
    def titsMap = text.findAll(/\(*\.\)\(.\)*/);
    def res = [:];

    titsMap.sort().each { tits ->
        def size = tits.split(/\./);
        if (size[0].size() == size[2].size())
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
