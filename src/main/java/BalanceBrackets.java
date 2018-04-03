import java.util.Stack;

public class BalanceBrackets {

    public static void main(String[] args) {
        String[] inputs = new String[] {
                "()[{}()]([[][]()[[]]]{()})([]()){[]{}}{{}}{}(){([[{}([]{})]])}",
                "{][({(}]][[[{}]][[[())}[)(]([[[)][[))[}[]][()}))](]){}}})}[{]{}{((}]}{{)[{[){{)[]]}))]()]})))[",
                "[)](][[([]))[)",
                "]}]){[{{){",
                "{[(}{)]]){(}}(][{{)]{[(((}{}{)}[({[}[}((}{()}[]})]}]]))((]][[{{}[(}})[){()}}{(}{{({{}[[]})]{((]{[){[",
                "()}}[(}])][{]{()([}[}{}[{[]{]](]][[))(()[}(}{[{}[[]([{](]{}{[){()[{[{}}{[{()(()({}([[}[}[{(]})",
                "){[])[](){[)}[)]}]]){](]()]({{)(]])(]{(}(}{)}])){[{}((){[({(()[[}](]})]}({)}{)]{{{",
                "[(})])}{}}]{({[]]]))]})]",
                "[{",
                "{}([{()[]{{}}}])({})",
                "{({}{[({({})([[]])}({}))({})]})}",
                "()[]",
                "{)[])}]){){]}[(({[)[{{[((]{()[]}][([(]}{](])()(}{(]}{})[)))[](){({)][}()((",
                "[][(([{}])){}]{}[()]{([[{[()]({}[])()()}[{}][]]])}",
                "(}]}",
                "(([{()}]))[({[{}{}[]]{}})]{((){}{()}){{}}}{}{{[{[][]([])}[()({}())()({[]}{{[[]]([])}})()]]}}",
                "[(([){[](}){){]]}{}([](([[)}[)})[(()[]){})}}]][({[}])}{(({}}{{{{])({]]}[[{{(}}][{)([)]}}",
                "()()[()([{[()][]{}(){()({[]}[(((){(())}))]()){}}}])]",
                "({)}]}[}]{({))}{)]()(](])})][(]{}{({{}[]{][)){}{}))]()}((][{]{]{][{}[)}}{)()][{[{{[[",
                ")}(()[])(}]{{{}[)([})]()}()]}(][}{){}}})}({](){([()({{(){{",
                "}([]]][[){}}[[)}[(}(}]{(}[{}][{}](}]}))]{][[}(({(]}[]{[{){{(}}[){[][{[]{[}}[)]}}]{}}(}"
        };
        String[] results = new String[] {
                "YES",
                "NO",
                "NO",
                "NO",
                "NO",
                "NO",
                "NO",
                "NO",
                "NO",
                "YES",
                "YES",
                "YES",
                "NO",
                "YES",
                "NO",
                "YES",
                "NO",
                "YES",
                "NO",
                "NO",
                "NO",
        };
        for(int i=0; i<inputs.length; i++) {
            if(!results[i].equals(perform(inputs[i])? "YES" : "NO")) {
                System.out.println(i);
            }
        }
        System.out.println(perform(inputs[8])? "YES" : "NO");
    }
    
    public static boolean perform(String input) {
        Stack<Character> brackets = new Stack<>();
        for(int i=0; i<input.length(); i++) {
            char singleChar = input.charAt(i);
            switch (singleChar) {
                case '(' :
                case '{' :
                case '[' :
                    brackets.push(singleChar);
                    break;
                case ')' :
                    if(brackets.isEmpty() || brackets.pop() != '(') return false;
                    break;
                case '}' :
                    if(brackets.isEmpty() || brackets.pop() != '{') return false;
                    break;
                case ']' :
                    if(brackets.isEmpty() || brackets.pop() != '[') return false;
                    break;
            }
        }
        return brackets.isEmpty();
    }
}
