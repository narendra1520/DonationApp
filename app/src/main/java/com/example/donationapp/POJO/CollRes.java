package com.example.donationapp.POJO;

import java.util.List;

public class CollRes {
        private boolean error;
        private String message;
        private List<Coll> data;

        public CollRes(boolean error, String message, List<Coll> data) {
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

        public List<Coll> getColl() {
            return data;
        }
}
