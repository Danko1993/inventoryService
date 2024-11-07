package com.daniel.kosk.microservices.inventoryservice.config;


import com.daniel.kosk.microservices.inventoryservice.entity.Category;
import com.daniel.kosk.microservices.inventoryservice.entity.Product;
import com.daniel.kosk.microservices.inventoryservice.repository.CategoryRepository;
import com.daniel.kosk.microservices.inventoryservice.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ProductDataInitializer implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        List<String> names = Arrays.asList("Power Tools", "Hand Tools", "Pneumatic Tools");
        if (categoryRepository.count() == 0) {
            for (String name : names) {
                Category category = new Category();
                category.setName(name);
                categoryRepository.save(category);
            }
        }
        List<String> productNames = Arrays.asList(
                "Cordless Drill", "Circular Saw", "Angle Grinder", "Impact Wrench", "Hammer Drill",
                "Hand Saw", "Screwdriver Set", "Measuring Tape", "Utility Knife", "Hammer",
                "Air Compressor", "Nail Gun", "Pneumatic Wrench", "Pneumatic Drill", "Spray Gun"
        );

        List<String> productDescriptions = Arrays.asList(
                "A lightweight drill with variable speed for easy control.",
                "A powerful saw with a rotating blade for cutting wood, metal, and plastic.",
                "A compact grinder for metal, concrete, and masonry work.",
                "A high-torque wrench ideal for tightening bolts and fasteners.",
                "A drill designed for high-impact tasks, ideal for drilling into concrete.",
                "A durable saw for cutting through wood and other materials.",
                "A complete set of screwdrivers for various tasks.",
                "A versatile measuring tool for precise measurements.",
                "A heavy-duty knife for cutting materials like carpet, cardboard, and plastic.",
                "A standard hammer for everyday tasks and repairs.",
                "A powerful air compressor for industrial and home use.",
                "A precision nail gun for fast and efficient nailing.",
                "A powerful pneumatic wrench for heavy-duty tasks.",
                "A drill powered by compressed air for various materials.",
                "A spray gun designed for painting and finishing tasks."
        );

        List<Category> categories = Arrays.asList(
                categoryRepository.findByName("Power Tools"),
                categoryRepository.findByName("Power Tools"),
                categoryRepository.findByName("Power Tools"),
                categoryRepository.findByName("Power Tools"),
                categoryRepository.findByName("Power Tools"),
                categoryRepository.findByName("Hand Tools"),
                categoryRepository.findByName("Hand Tools"),
                categoryRepository.findByName("Hand Tools"),
                categoryRepository.findByName("Hand Tools"),
                categoryRepository.findByName("Hand Tools"),
                categoryRepository.findByName("Pneumatic Tools"),
                categoryRepository.findByName("Pneumatic Tools"),
                categoryRepository.findByName("Pneumatic Tools"),
                categoryRepository.findByName("Pneumatic Tools"),
                categoryRepository.findByName("Pneumatic Tools")
        );

        List<Double> prices = Arrays.asList(
                150.00, 200.00, 180.00, 220.00, 250.00,
                25.00, 15.00, 10.00, 12.00, 20.00,
                300.00, 180.00, 350.00, 250.00, 150.00
        );

        List<Integer> stockQuantities = Arrays.asList(
                100, 50, 75, 60, 80,
                200, 150, 180, 100, 250,
                30, 40, 20, 25, 50
        );

        List<String> imagePaths = Arrays.asList(
                "src\\resources\\static\\photos\\power_tools_cordless_drill.jpg",
                "src\\resources\\static\\photos\\power_tools_circular_saw.jpg",
                "src\\resources\\static\\photos\\power_tools_angle_grinder.jpg",
                "src\\resources\\static\\photos\\power_tools_impact_wrench.jpg",
                "src\\resources\\static\\photos\\power_tools_hammer_drill.jpg",
                "src\\resources\\static\\photos\\hand_tools_hand_saw.jpg",
                "src\\resources\\static\\photos\\hand_tools_screwdriver_set.jpg",
                "src\\resources\\static\\photos\\hand_tools_measuring_tape.jpg",
                "src\\resources\\static\\photos\\hand_tools_utility_knife.jpg",
                "src\\resources\\static\\photos\\hand_tools_hammer.jpg",
                "src\\resources\\static\\photos\\pneumatic_tools_air_compressor.jpg",
                "src\\resources\\static\\photos\\pneumatic_tools_nail_gun.jpg",
                "src\\resources\\static\\photos\\pneumatic_tools_pneumatic_wrench.jpg",
                "src\\resources\\static\\photos\\pneumatic_tools_pneumatic_drill.jpg",
                "src\\resources\\static\\photos\\pneumatic_tools_spray_gun.jpg"
        );


        List<String> producerCodes = Arrays.asList(
                "PRODPT01", "PRODPT02", "PRODPT03", "PRODPT04", "PRODPT05",
                "PRODHT01", "PRODHT02", "PRODHT03", "PRODHT04", "PRODHT05",
                "PRODPT06", "PRODPT07", "PRODPT08", "PRODPT09", "PRODPT10"
        );

        List<Double> weights = Arrays.asList(
                2.2, 5.5, 3.4, 2.8, 3.6,
                1.5, 0.8, 0.2, 0.3, 1.0,
                30.0, 6.5, 12.0, 8.0, 3.0
        );

        List<String> brands = Arrays.asList(
                "PowerMax", "SawTech", "GrindPro", "TorqueX", "DrillForce",
                "HandCraft", "ToolMaster", "MeasurePro", "CutRight", "HammerCo",
                "AirForce", "NailTech", "WrenchPro", "PneumoTools", "PaintRight"
        );

        List<String> models = Arrays.asList(
                "PD2024", "SC2024", "AG2024", "IW2024", "HD2024",
                "HS2024", "SS2024", "MT2024", "UK2024", "HM2024",
                "AC2024", "NG2024", "PW2024", "PD2024", "SG2024"
        );

        List<String> currencies = Arrays.asList(
                "USD", "USD", "USD", "USD", "USD",
                "USD", "USD", "USD", "USD", "USD",
                "USD", "USD", "USD", "USD", "USD"
        );

        if (productRepository.count() == 0 ){
            for (int i = 0; i < productNames.size(); i++) {
                Product product = new Product();
                product.setName(productNames.get(i));
                product.setDescription(productDescriptions.get(i));
                product.setCategory(categories.get(i));
                product.setPrice(prices.get(i));
                product.setStockQuantity(stockQuantities.get(i));
                product.setImagePath(imagePaths.get(i));
                product.setProducerCode(producerCodes.get(i));
                product.setWeight(weights.get(i));
                product.setBrand(brands.get(i));
                product.setModel(models.get(i));
                product.setCurrency(currencies.get(i));
                productRepository.save(product);
            }
        }

    }

}
