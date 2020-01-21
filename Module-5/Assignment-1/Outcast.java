public class Outcast{
    private WordNet wnt;
    public Outcast(WordNet wordnet){
        wnt=wordnet;
    }
    public String outcast(String[] nouns){
        int maximum=0;
        String finalOutcast="";
        for(String noun:nouns){
            int currentOutcast=0;
            for(String oNoun:nouns){
                if(oNoun!=noun){
                    currentOutcast+=wnt.distance(noun,oNoun);
                }
            }
            if(currentOutcast>maximum){
                maximum=currentOutcast;
                finalOutcast=noun;
            }
        }
        return finalOutcast;
    }
    public static void main(String[] args){
        // WordNet wordnet=new WordNet(args[0],args[1]);
        // Outcast outcast=new Outcast(wordnet);
        // for(int e=2;e<args.length;e++){
        //     String[] nouns=In.readString(args[t]);
        //     StdOut.println(args[t]+":"+outcast.outcast(nouns));
        // }
    }
}