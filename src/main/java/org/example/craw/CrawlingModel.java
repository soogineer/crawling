package org.example.craw;

public class CrawlingModel {



        private String manufacturer;
        private String modelGroup;
        private String model;

        public CrawlingModel(String manufacturer, String modelGroup, String model) {
            this.manufacturer = manufacturer;
            this.modelGroup = modelGroup;
            this.model = model;

        }

        public String getManufacturer() {
            return manufacturer;
        }

        public String getModelGroup() {
            return modelGroup;
        }

        public String getModel() {
            return model;
        }




        @Override
        public String toString() {
            return "Car [manufacturer=" + manufacturer + ", modelGroup=" + modelGroup + ", model=" + model + "]";
        }

    }
