void process() {
//    BufferedReader bufferedReader = new BufferedReader(new FileReader('/home/ais/projects/algorithms/task_2/text.txt'));

    def fis = new FileInputStream('/home/ais/projects/algorithms/task_2/text.txt')
//    Long allSize = fis.available();
    int step = 1024 * 1024 * 50;

    byte[] buffer = new byte[step];

    def res = [:];
    print('[');
    while ((read = fis.read(buffer)) != -1) {
        def titsMap = new String(buffer, "UTF-8").findAll(/\(*\.\)\(.\)*/);

        print(".");

        titsMap.sort().each { tits ->
            def size = tits.split(/\./);
            if (size[0].size() == size[2].size())
                if (res[tits])
                    res[tits] = res[tits] + 1;
                else
                    res[tits] = 1;
        };
    }
//    println();
//    res.sort().each { k, v -> println "${k}:${v}" };

}

println "Start processing";
for (def i = 0; i < 10; i++) {
    def start = new Date();
    process();
    def end = new Date();
    println "] -- Time: ${end.getTime() - start.getTime()}";
}
