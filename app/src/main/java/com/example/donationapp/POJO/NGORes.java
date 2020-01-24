package com.example.donationapp.POJO;

import java.util.List;

public class NGORes {
        private boolean error;
        private String message;
        private List<NGO> data;

        public NGORes(boolean error, String message, List<NGO> data) {
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

        public List<NGO> getNgo() {
            return data;
        }
}
