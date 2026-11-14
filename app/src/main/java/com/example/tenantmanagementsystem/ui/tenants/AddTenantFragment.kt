package com.example.tenantmanagementsystem.ui.tenants

import android.widget.Toast
import androidx.navigation.fragment.findNavController
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels                      // ✅ import 1 of 2 (you already had it)
import com.example.tenantmanagementsystem.databinding.FragmentAddTenantBinding
import com.example.tenantmanagementsystem.ui.viewmodel.TenantViewModel     // ✅ import 2 of 2 (you already had it)
// ✅ REMOVED: import ...data.repository.TenantRepository (no longer used)
// ✅ REMOVED: import ...data.model.Tenant (no longer named in this file)

class AddTenantFragment : Fragment() {

    private var _binding: FragmentAddTenantBinding? = null

    private val binding get() = _binding!!

    // ✅ viewModel line (you already had it)
    // The SHARED ViewModel: every Fragment in MainActivity gets the SAME one
    private val viewModel: TenantViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddTenantBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // saveButton ← android:id="@+id/saveButton" in fragment_add_tenant.xml
        // ✅ CHANGED: the whole block below replaces your old saveButton block
        binding.saveButton.setOnClickListener {

            // UI JOB: collect the input. The ViewModel trims, checks and saves it
            val tenant = viewModel.addTenant(
                binding.tenantNameEditText.text.toString(),
                binding.phoneEditText.text.toString(),
                binding.rentEditText.text.toString()
            )

            // null = rejected. UI JOB: tell the user
            if (tenant == null) {
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // UI JOB: navigate with Safe Args (unchanged)
            val action = AddTenantFragmentDirections
                .actionAddTenantFragmentToViewTenantsFragment(tenant)
            findNavController().navigate(action)
        }
    }
}