We were expected to design and implement a processor which supports instruction set:
(AND, ADD, LD, ST, ANDI, ADDI, CMP, JUMP, JE, JA, JB, JBE, JAE). Processor will have 16 bits address
width and 16 bits data width. Processor will have 5 parts as follows. Register File will hold register values
and signal to write into any register. There will be 8 registers in processor. Instruction Memory will be a
read-only memory and instructions will be stored in this component. If the current instruction is not one
of the JUMP instructions(JUMP, JE, JA etc.); the next instruction will be fetched and executed
consecutively from this memory. Data Memory will be read-write memory which will store data.
Program will be able to read data from data memory, and also store data to this memory. Data Memory
will have 10 bits address width, and 16 bits data width. Control Unit will produce proper signals to all
datapath components. For example if the instruction is ST, control unit should produce memWrite signal
which will allow Data Memory component to write data value on its data input to the address on its
address input. Arithmetic Logic Unit (ALU) will compute arithmetic operations ADD,AND,ADDI,ANDI.
Operands will be fetched from register+register or register+ immediate value. Result will be stored to
the Register File. Control unit should produce proper signals to ALU according to instruction opcode
(Every instruction should have distinct operational code). Detailed information about instructions is given CSE 315 Project 2020.pdf
