class Pet:
    def __init__(self, name, age, species) -> None:
        self.name = name
        self.age = age
        self.species = species
        self.is_available_for_adoption = True
        self.shelter = None  # Reference to the shelter the pet belongs to
    
    def display_info(self):
        """Displays the pet's information and adoption status."""
        status = "available" if self.is_available_for_adoption else "adopted"
        print(f"Name: {self.name}, Age: {self.age}, Species: {self.species}, Status: {status}")
        
    def make_sound(self):
        """Default method for animal sound, meant to be overridden."""
        print(f"{self.name} the {self.species} makes a sound.")