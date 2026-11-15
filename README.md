# Tenant Management System
An Android app for landlords to record tenants, see total rent, and call tenants.
## Download
Latest APK: see **Releases** on the right of this page.
## Features
- Register and log in
- Dashboard with number of tenants and total rent
- Add tenants and view all tenants (saved with Room)
- Call a tenant, options menu and navigation drawer
## Architecture
ui/ Activities, Fragments and TenantViewModel (UI layer)
data/ Tenant, TenantDao, TenantDatabase, TenantRepository (data layer)
Screens → TenantViewModel (LiveData) → TenantRepository → Room
## Team
| Stage | Member            | Admission No. | Pull request |
|---|-------------------|---------------|---|
| 1 Lead | Mitchell King'ori | 190327        | https://github.com/Kingorimish/TenantManagementSystem.git |
| 2 ViewModel | Joshua Mwangi     | 190504        | (https://github.com/Kingorimish/TenantManagementSystem/pull/1) |
| 3 Room | Nia Angel         | 189796        | (https://github.com/Kingorimish/TenantManagementSystem/pull/2) |
| 4 Screens | Grace Githuku     | 191606        | https://github.com/Kingorimish/TenantManagementSystem/pull/3 |
| 5 Data integration | Najma Chueb       | 189579        | (https://github.com/Kingorimish/TenantManagementSystem/pull/4) |
| 6 Release | Amy Musyoka       | 163420        | (link) |