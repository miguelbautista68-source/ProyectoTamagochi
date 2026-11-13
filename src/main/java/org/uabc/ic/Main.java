package org.uabc.ic;

import org.uabc.ic.modelo.Tamagochi;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Tamagochi t1 = new Tamagochi();
        System.out.println(t1);  // llama toString() automáticamente

        // Con el constructor parametrizado
        Tamagochi t2 = new Tamagochi("Luna", 80, 30, 90, 70);
        System.out.println(t2.toString());
    }
}
