import java.util.*;

class Prac1
{
    public static void main(String []arg)
    {
        Map<String, Integer> symbol = new HashMap<>();
        Map<String, Integer> opcode = new HashMap<>();

        int LC = 0;

        opcode.put("STOP", 0);
        opcode.put("ADD", 1);
        opcode.put("SUB", 2);
        opcode.put("MOVER", 3);
        opcode.put("MOVEM", 4);
        opcode.put("READ", 5);
        opcode.put("PRINT", 6);

        String[] code = {
            "START 100",
            "READ A",
            "READ B",
            "ADD A B",
            "MOVEM RESULT",
            "PRINT RESULT",
            "RESULT DS 1",
            "END"
        };

        System.out.println("---------- PASS 1 ----------");

        for(String line : code)
        {
            String []parts = line.split(" ");
            String op = parts[0];

            if(op.equals("START"))
            {
                LC = Integer.parseInt(parts[1]);
                continue;
            }

            if(op.equals("END"))
                break;

            if(parts.length == 3 && !opcode.containsKey(op))
            {
                symbol.put(parts[0], LC);
                op = parts[1];
            }
            else if(parts.length == 2 && !opcode.containsKey(op))
            {
                symbol.put(parts[0], LC);
                op = "DS";
            }

            System.out.println(LC + "\t" + op + "\t" + Arrays.toString(parts));

            LC++;
        }

        System.out.println("\nSymbol Table");
        for (Map.Entry<String, Integer> i : symbol.entrySet()) {
            System.out.println(i.getKey() + " -> " + i.getValue());
        }

        System.out.println("\n---------- PASS 2 ----------");
        for(String line : code)
        {
            String []parts = line.split(" ");
            String op = parts[0];

            if(parts[0].equals("START"))
            {
                LC = Integer.parseInt(parts[1]);
                continue;
            }

            if(opcode.containsKey(op))
            {
                int opc = opcode.get(op);
                int address = 0;

                if(parts.length > 1 && symbol.containsKey(parts[1]))
                {
                    address = symbol.get(parts[1]);
                }

                System.out.println(LC + "\t" + opc + "\t" + address);
            }

            LC++;
        }

    }
}