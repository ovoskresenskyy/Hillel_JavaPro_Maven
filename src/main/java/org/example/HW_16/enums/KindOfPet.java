package org.example.HW_16.enums;

public enum KindOfPet {
    CAT {
        @Override
        public String toString() {
            return "Cat";
        }
    },
    DOG {
        @Override
        public String toString() {
            return "Dog";
        }
    }
}
