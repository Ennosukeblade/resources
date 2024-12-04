from pet import Pet

class Shelter:
    total_adoptions = 0
    opening_hours = {"weekday": "9 AM to 6 PM", "weekend": "10 AM to 4 PM"}

    def __init__(self, name):
        self.name = name
        self.pets = []

    def add_pet(self, pet: Pet):
        """Adds a pet to the shelter and sets its shelter reference."""
        if self.validate_pet_name(pet.name):
            pet.shelter = self  # Link pet to this shelter
            self.pets.append(pet)
            print(f"{pet.name} has been added to {self.name}.")
        else:
            print(f"Failed to add {pet.name}: invalid pet name.")
    
    def list_pets(self):
        """Lists all pets in the shelter with their information."""
        if self.pets:
            print(f"{self.name} Shelter Pets:")
            for pet in self.pets:
                pet.display_info()
        else:
            print("No pets in the shelter currently.")

    def find_pet_by_name(self, name):
        """Finds a pet by name."""
        return next((pet for pet in self.pets if pet.name.lower() == name.lower()), None)
    
    def adopt_pet(self, name):
        """Adopts a pet if it is available."""
        pet = self.find_pet_by_name(name)
        if pet is None:
            print(f"No pet found with the name '{name}'.")
        elif not pet.is_available_for_adoption:
            print(f"{pet.name} is already adopted.")
        else:
            pet.is_available_for_adoption = False
            self.record_adoption()
            print(f"{pet.name} has been adopted from {self.name}!")
    
    def return_pet(self, name):
        """Returns a pet to the shelter and makes it available for adoption."""
        pet = self.find_pet_by_name(name)
        if pet is None:
            print(f"No pet found with the name '{name}'.")
        elif pet.is_available_for_adoption:
            print(f"{pet.name} is already available for adoption.")
        else:
            pet.is_available_for_adoption = True
            print(f"{pet.name} has been returned to the shelter and is now available for adoption.")
    
    @classmethod
    def record_adoption(cls):
        """Increases the total adoptions counter."""
        cls.total_adoptions += 1
        print(f"Total adoptions so far: {cls.total_adoptions}")
        
    @staticmethod
    def show_opening_hours(day_type):
        """Displays opening hours based on the day type."""
        hours = Shelter.opening_hours.get(day_type, "Invalid day type")
        print(f"Shelter {day_type.capitalize()} Hours: {hours}")
        
    @staticmethod
    def validate_pet_name(name):
        """Validates pet names to be alphabetic and within 3-20 characters."""
        is_valid = name.isalpha() and 3 <= len(name) <= 20
        print(f"{name} is {'a valid' if is_valid else 'not a valid'} pet name.")
        return is_valid
    
    