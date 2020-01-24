package com.example.donationapp.POJO;

import java.util.List;

public class CategoryRes {
        private boolean error;
        private String message;
        private List<String> data;

        public CategoryRes(boolean error, String message, List<String> data) {
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

        public List<String> getCat() {
            return data;
        }
}
