public class Patient {
	String last_name;
	String dob;
	String gn;
	String first_name;

	public boolean isEquals(Patient m) {
		if (m.dob.equalsIgnoreCase(this.dob))
			if (m.gn.equalsIgnoreCase(this.gn)) {
				String name1;
				String name2;
				name1 = m.first_name;
				name2 = this.first_name;
				String[] nam1 = name1.split(" ");
				String[] nam2 = name2.split(" ");
				if (nam1[0].equalsIgnoreCase(nam2[0])) {
					name1 = m.last_name;
					name2 = this.last_name;
					String[] nm1 = name1.split(" ");
					String[] nm2 = name2.split(" ");
					if (nm1[0].equalsIgnoreCase(nm2[0]))
						return true;
				}

			}
		return false;
	}

}
