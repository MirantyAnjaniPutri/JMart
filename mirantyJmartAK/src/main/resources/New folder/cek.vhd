-- library
library ieee;
use ieee.std_logic_1164.all;

-- entity
entity fsm_project is
	port(
		-- bagian input
		C, O, CLK: IN STD_LOGIC;
		--bagian output
		Z : OUT STD_LOGIC
	);
end fsm_project;

-- architecture
architecture arch of fsm_project is
	type state_type is (ST0, ST1, ST2);
	signal PS, NS: state_type;
begin

	sync_proc: process(CLK, NS)
	begin
		if (rising_edge(CLK)) then PS <= NS;
		end if;
	end process;
	
	comb_proc: process(D, N)
	begin
		Z <= "00"; 
	
		case PS is 
			when ST0 =>
				Z <= "00";
				if (C = "00") then NS <= ST0;
				elsif (C = "01" and O = "00") then NS <= ST1;
				elsif (C = "10" and O = "00") then NS <= ST1;
                elsif (C = "11" and O = "00") then NS <= ST1;
				end if;
			when ST1 =>
				Z <= "01";
				if (C = "01" and O = "00") then NS <= ST0;
				elsif (C = "10" and O = "00") then NS <= ST0;
				elsif (C = "11" and O = "00") then NS <= ST0;
                elsif (C = "01" and O = "01") then NS <= ST2;
                elsif (C = "11" and O = "01") then NS <= ST2;
                elsif (C = "11" and O = "01") then NS <= ST2;
				end if;
			when ST2 =>
				Z <= "11";
				if (C = "01" and O = "00") then NS <= ST0;
				elsif (C = "10" and O = "00") then NS <= ST0;
				elsif (C = "11" and O = "01") then NS <= ST0;
				end if;
		end case;
	end process;
end arch;