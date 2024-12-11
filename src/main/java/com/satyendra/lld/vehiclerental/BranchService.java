package com.satyendra.lld.vehiclerental;

import java.util.ArrayList;
import java.util.List;

public class BranchService {

    List<Branch> branches;
    private final VehicleService vehicleService;

    public BranchService(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
        this.branches = new ArrayList<>();
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    public void addBranch(Branch branch, List<Vehicle> vehicleList) {
        if (isBranchExist(branch)) {
            throw new RuntimeException("Branch already exists");
        }
        branches.add(branch);
        for(Vehicle vehicle : vehicleList) {
            vehicleService.addVehicle(vehicle, branch);
        }
    }

    private boolean isBranchExist(Branch newBranch) {
        for(Branch branch : this.branches) {
            if(branch.getName().equalsIgnoreCase(newBranch.getName())) {
                return true;
            }
        }
        return false;
    }

    public Branch getBranchByName(String name) {
        for(Branch branch : branches) {
            if(branch.getName().equalsIgnoreCase(name)) {
                return branch;
            }
        }
        return null;
    }
}
