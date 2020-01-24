package com.example.donationapp.POJO;

import java.util.List;

public class CollDetailsRes {
        private boolean error;
        private String message;
        private CollDetails data;

        public CollDetailsRes(boolean error, String message, CollDetails data) {
            this.error = error;
            this.message = message;
            this.data = data;
        }

        public boolean isError() {
            return error;
        }

        public String getMessage() {
            return message;
        }

        public CollDetails getCollDetails() {
            return data;
        }
}
